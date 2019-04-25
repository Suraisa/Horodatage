FILE_PROJECT = App
LIB = lib
LIB_DIRECTORIES = $(LIB)/opencv
SRC = src
SRC_FILES := $(shell echo `du -a src | awk '$$2 ~ /.java/ {print $$2}'`)
BIN = bin

fin = \033[0m
vert_gras = \033[0;1;32m
bleu = \033[0;34m
vert = \033[0;32m

c:
	@echo -e "${vert_gras}+--------------------[ Compilation ]--------------------+ ${fin}"
	javac -d bin -classpath $(LIB)/*.jar $(SRC_FILES)
	@echo -e "${vert_gras}+----------------[ Compilation terminée ]---------------+ ${fin}"

e:
	@echo -e "${vert_gras}+--------------------[ Exécution ]--------------------+ ${fin}"
	java -Djava.library.path=$(LIB_DIRECTORIES) -classpath $(BIN):$(LIB)/* $(FILE_PROJECT)
	@echo -e "${vert_gras}+----------------[ Exécution terminée ]---------------+ ${fin}"

ce :
	make c
	make e