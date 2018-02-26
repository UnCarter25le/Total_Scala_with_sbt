
//定義ch08_package.cn.scala.chapter08的套件，在裡面定義一個類別Teacher
//在程式的任何地方，都可以透過ch08_package.cn.scala.chapter08.Teacher來使用這個Teacher類別
package ch08_package{
  package cn{
    package scala{
      package chapter08{
        class Teacher(var name:String) extends App {
          //示範套件的存取規則
          //內層套件（ch08_package.cn.scala.chapter08）可以存取外層套件（ch08_package.cn.scala）定義的類別或物件，無須引用
          def printName()={
            Utils.toString(name)
          }

        }
      }
    }
  }
}


//以下是將package的路徑簡化版
//package ch08_package.cn.scala.chapter08 {
//
//  class Teacher extends App {
//
//  }
//}
