FILE_PROJECT = App
LIB = lib
LIB_DIRECTORIES = $(LIB)/opencv
SRC = src

fin = \033[0m
vert_gras = \033[0;1;32m
bleu = \033[0;34m
vert = \033[0;32m

c:
	@echo -e "${vert_gras}+--------------------[ Compilation ]--------------------+ ${fin}"
	javac -classpath $(LIB)/*.jar $(SRC)/$(FILE_PROJECT).java
	@echo -e "${vert_gras}+----------------[ Compilation terminée ]---------------+ ${fin}"

e:
	@echo -e "${vert}+--------------------[ Exécution ]--------------------+ ${fin}"
	java -Djava.library.path=$(LIB_DIRECTORIES) -classpath $(SRC):$(LIB)/* $(FILE_PROJECT)
	@echo -e "${vert}+----------------[ Exécution terminée ]---------------+ ${fin}"

ce :
	make c
	make e