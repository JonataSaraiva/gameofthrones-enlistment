# Getting Started

### Reference Documentation
The finality of this project is to test performatic ways to execute a http request. The requests are sent to that [api](https://github.com/JonataSaraiva/gameofthronesapi). That service has a 
toxiproxy layer to simulate an enviroment near production. 

Stack of this app:

* [Kotlin](https://kotlinlang.org/)
* [Gradle](https://docs.gradle.org)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#boot-features-developing-web-applications)

### First stack case
At class [StarkEnlistment](https://github.com/JonataSaraiva/gameofthrones-enlistment/blob/main/src/main/kotlin/com/own/gameofthronesenlistment/enlistment/service/StarkEnlistment.kt) we can see a strategy request using Kotlin Courotines + Feign Client,
coroutines are a really light and powerful choose and we were able to do dozens of request in parallel with no problems. 


