package com.turkcell;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {
    //OOP ==> Object Oriented Programming

    //instance üretmek
//    Student student1 = new Student();
//    student1.setNumber(1);
//    student1.setName("Fenasi");
//    student1.joinClass("Yazılım");
//
//
//    Student student2 = new Student();
//    student2.setNumber(2);
//    student2.setName("Kerim");
//    student2.joinClass("Fizik");
//
//    Student student3 = new Student(1, "Abuzittin");
//    student3.joinClass("İngiliççe");

//    System.out.println(student1.number + " numaralı öğrencinin ismi: " + student1.name);
//    System.out.println(student2.number + " numaralı öğrencinin ismi: " + student2.name);
//
//    sumNumbers(5, 26);
//    int result = sumNumbers(5,26); // değeri alıp üzeinden 10 çıkarmak istioyruz
//    System.out.println("10 çıkarınca sonuç: " + (result - 10));
//    sumNumbers(0, 52);
    Student student = new Student("Mustafa", 44);
    Teacher teacher = new Teacher("Alaattin");
    Book book1 = new Book("Kürk Mantolu Madonna", "Sabahattin Ali");

    student.rentBook(book1.getBookName());
    teacher.rentBook(student, book1);
    student.deliverBook(book1.getBookName());



  }

  //(erişim belirteci) (static opsiyonel) (dönüş tipi) (Method ismi)
//  public static int sumNumbers(int num1, int num2) {
//    int result = num1 + num2;
//
//    System.out.println();
//
//    return result;
//  }
}

