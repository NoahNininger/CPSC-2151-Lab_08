test: cpsc2150/MyDeque/*.java
		javac -Xlint -cp .:/usr/share/java/junit4.jar cpsc2150/MyDeque/*.java

runInt: cpsc2150/MyDeque/IDeque.java cpsc2150/MyDeque/ArrayDeque.java cpsc2150/MyDeque/ListDeque.java cpsc2150/MyDeque/DequeApp.java
		java cpsc2150.MyDeque.DequeApp

runChar: cpsc2150/MyDeque/IDeque.java cpsc2150/MyDeque/ArrayDeque.java cpsc2150/MyDeque/ListDeque.java cpsc2150/MyDeque/CharacterDequeApp.java
		java cpsc2150.MyDeque.CharacterDequeApp

testArr: cpsc2150/MyDeque/*.class
		java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.MyDeque.TestArrayDeque

testList: cpsc2150/MyDeque/*.class
		java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.MyDeque.TestListDeque

clean:
		rm -f cpsc2150/MyDeque/*.class
