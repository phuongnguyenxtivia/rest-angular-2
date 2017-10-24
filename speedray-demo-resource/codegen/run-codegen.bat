SET LANG_JAVA=java
SET LANG_JS=javascript
SET LANG_TS=typescript-angular
SET LANG_JAXRS=jaxrs

: should change 2 inputs below to point to your YAML file and output folder
SET INPUT_YAML=C:/dev/ws/liferay-ws/modules/dxp-book-rest-client/books.yaml
SET OUTPUT_CODEGEN=c:/dev/temp/codegen

RD /S /Q "%OUTPUT_CODEGEN%"
MKDIR "%OUTPUT_CODEGEN%"

: Generate Java code
CALL JAVA -jar c:/dev/swagger-codegen-cli.jar generate -i %INPUT_YAML% -l %LANG_JAVA% -o %OUTPUT_CODEGEN%/%LANG_JAVA%

: Generate Javascript code
CALL JAVA -jar c:/dev/swagger-codegen-cli.jar generate -i %INPUT_YAML% -l %LANG_JS% -o %OUTPUT_CODEGEN%/%LANG_JS%

: Generate Typescript code
CALL JAVA -jar c:/dev/swagger-codegen-cli.jar generate -i %INPUT_YAML% -l %LANG_TS% -o %OUTPUT_CODEGEN%/%LANG_TS%

: Generate jaxrs code
CALL JAVA -jar c:/dev/swagger-codegen-cli.jar generate -i %INPUT_YAML% -l %LANG_JAXRS% -o %OUTPUT_CODEGEN%/%LANG_JAXRS%
