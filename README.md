# DateTimeLibrary

Begin by adding the following to your project level build.gradle file:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  

Then add this to the MODULE level build.gradle file:

	dependencies {
	        implementation 'com.github.adamsawyer391:DateTimeLibrary:1.0.0'
	}
  
