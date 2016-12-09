// import 'rxjs/add/operator/switchMap';

// import { Component, OnInit } from '@angular/core';
// import { Observable } from 'rxjs/Observable';
// import { Router, ActivatedRoute, Params } from '@angular/router';

// import { SamplesApi } from '../../generated/index';
// import { Book } from '../../generated/model/book';

// @Component({
//     selector: 'book-add',
//     templateUrl: '/o/dxpbookrestclient/books/book-add.component.html'
// })
// export class BookAddComponent implements OnInit {
// 	errorMessage: string;
//     book : Book;

//     constructor(
//         private sampleApi: SamplesApi,
//         private route: ActivatedRoute,
//         private router: Router
//     ) {}

//     ngOnInit() {
//         this.book = {};
//     }   

//     addBook() {
//         this.sampleApi.addBook(this.book)
//             .subscribe(
//                 (book: Book) => { 
//                     // reset for new book
//                     this.book = {};
//                 }, 
//                 error =>  this.errorMessage = <any>error);
//     }

//     goToBookList() {
//         this.router.navigate(['/books']);
//     }
// }


import 'rxjs/add/operator/switchMap';

import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Router, ActivatedRoute, Params } from '@angular/router';
// We will need to import a couple of specific API’s for dealing with reactive forms
import { FormGroup, FormControl, Validators, FormBuilder  } from '@angular/forms'; 

import { SamplesApi } from '../../generated/index';
import { Book } from '../../generated/model/book';

@Component({
    selector: 'book-add',
    templateUrl: '/o/dxpbookrestclient/books/book-add-reactive.component.html'
})
export class BookAddComponent implements OnInit {
    // The FormGroup object as you may remember from the simple form example exposes various API’s for dealing with forms. Here we are creating a new object and setting its type to FormGroup
    form : FormGroup;
    errorMessage: string;
    book: Book = {};
    active = true;

    // We are passing an instance of the FormBuilder to our constructor
    constructor(
        private sampleApi: SamplesApi,
        private route: ActivatedRoute,
        private router: Router,
        private fb: FormBuilder
    ) {}

    ngOnInit(): void {
        this.buildForm();
    }  


    buildForm(): void {
        this.form = new FormGroup({
            isbn: new FormControl({value: this.book.isbn, disabled: true}),
            title: new FormControl(this.book.title, [
                    Validators.required,
                    Validators.minLength(4),
                    Validators.maxLength(30)//,
                    //forbiddenNameValidator(/bob/i)
                ]
            ),
            author: new FormControl(this.book.author, Validators.required),
            summary: new FormControl(this.book.summary),
        });

        this.form.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged(); // (re)set validation messages now
    }

    onValueChanged(data?: any) {
        if (!this.form) { return; }
        const form = this.form;

        for (const field in this.form) {
            // clear previous error message (if any)
            this.formErrors[field] = '';
            const control = form.get(field);

            if (control && control.dirty && !control.valid) {
                const messages = this.validationMessages[field];
                for (const key in control.errors) {
                    this.formErrors[field] += messages[key] + ' ';
                }
            }
        }
    }

    formErrors = {
        'title': '',
        'author': ''
    };

    validationMessages = {
        'title': {
            'required':      'Title is required.',
            'minlength':     'Title must be at least 4 characters long.',
            'maxlength':     'Title cannot be more than 24 characters long.'//,
            //'forbiddenName': 'Someone named "Bob" cannot be a hero.'
        },
        'author': {
            'required': 'Author is required.'
        }
    };

    
    addBook(book: Book) {
        this.sampleApi.addBook(book)
            .subscribe(
                (book: Book) => { 
                    // reset for new book
                    this.form.reset();

                    this.book = {};
                    this.buildForm();

                    this.active = false;
                    setTimeout(() => this.active = true, 0);
                }, 
                error =>  this.errorMessage = <any>error);
    }

    submitForm(value: any):void{
        this.addBook(value);
    }

    goToBookList() {
        this.router.navigate(['/books']);
    }
}