-am folosit functii separate pentru logica de desenare (genereazaDreptunghi, genereazaCerc) si pentru transformarea matricei in text (transformaInString).

Dreptunghi: am folosit o conditie de incadrare a indicilor pentru a desena un obiect negru pe fundal alb.

Cerc: am implementat formula distantei euclidiene (x^2 + y^2 <= r^2) pentru a desena un cerc alb pe fundal negru.

Pentru a rula cu dimensiuni mari, am ajustat memoria Heap a JVM:
java -Xms4G -Xmx4G --enable-preview --source 21 Main.java 35000 cerc

De asemenea, din cauza rezolutiei din consola am dublat caracterele Unicode pentru ca forma acestora alipite sa fie un patrat.

Timpul de executie il determinam prin scaderea T sfarsit- T inceput