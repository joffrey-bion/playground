set -xe

rm -rf build

kotlinc lib-v1/Lib.kt -cp kotlin-stdlib-1.9.23.jar -d build/lib-v1
kotlinc lib-v2/Lib.kt -cp kotlin-stdlib-1.9.23.jar -d build/lib-v2 -Xjvm-default=all-compatibility

kotlinc app/Main.kt -cp "build/lib-v1;kotlin-stdlib-1.9.23.jar" -d build/app.jar

java -cp "build/lib-v2;kotlin-stdlib-1.9.23.jar;build/app.jar" app.MainKt
