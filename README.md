# NTS_RecodMaker

JAVA -Version
---
```
* java version "1.8.0_91"
* Java(TM) SE Runtime Environment (build 1.8.0_91-b14)
* Java HotSpot(TM) Client VM (build 25.91-b14, mixed mode, sharing)
```

문제
----

####설명
* 사원번호와 성적을 출력하는 프로그램을 만드시오.
* "사원번호공백점수"형태로 count 개의 줄이 출력되어야 합니다.

####조건 
- 사원번호에서 NT는 바뀔 수 없고, 뒤의 다섯 자리는 random 숫자.
- random 값이 99999 이하면 0으로 채움.(ex - 30이라면 NT00030)
- 사원번호 중복 안됨.
- score는 0점 이상 100점 미만의 random 값.

####실행
~> java RecordMaker [count]

####동작
```
예 : ~> java RecordMaker 3
NT00002 80
NT11206 85
NT01321 15
```




