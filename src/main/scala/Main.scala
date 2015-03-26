import scala.collection.immutable.HashMap

object Main extends App {


    val filePersonsTable = "persons.db"
    val mainMenu = HashMap(0 -> "Какую операцию вы хотите выполнить?",
        2 -> "Новый клиент / изменение личной информации",
        3 -> "Оформить абонемент",
        4 -> "Отметить клиента",
        1 -> "Выход (закончить работу)")

    val newClientMenu = HashMap(0 -> "Работа с новыс клиентом?",
        2 -> "Оформить нового",
        3 -> "Изменить данные",
        1 -> "Выход в др. меню")

    val newClientInput = List("ФИО","День рождения ДД.ММ.ГГГГ", "телефон +79993332211", "Электронная почта")

    var exit = false
    var menuPointer = -1

    while(!exit){
        menuPointer = menu(mainMenu)
        exit = menuPointer match {
            case 1 => true
            case 2 =>
                while(!exit){
                    menuPointer = menu(newClientMenu)
                    exit = menuPointer match {
                        case 1 => true
                        case 2 =>
                            var i = 0;
                            var sTemp: List[String] = List.empty
                            for (s <- newClientInput){
                                print(s+" :")
                                sTemp ++= readLine()
                            }
                            if (sTemp.size == newClientInput.size){

                            } else print("ERROR")
                            false
                        case _ => false
                    }
                }
                false
            case _ => false
        }
    }

    def menu(lines: Map[Int, String]): Int = {
        var exit = false
        var qu = -1
        do {
            for (l <- lines) {
                if (l._1 == 0) println(l._2) else println(l._1 + " - " + l._2)
            }
            qu = Console.readInt()
        } while (!(qu < lines.size) && (qu > 0))
        qu
    }
}

class dbPerson(number: Int = 0,
               surname: String,
               birthday: String,
               phone: String,
               email: String)


//
//Active: (информация об активных абонементах)
//number - (Person.number) - уникальный номер человека
//type - вид абонемента
//    kind - направление
//start - дата начала
//
//Visits: (информация о посящениях: какой день и какое время)
//number - (Person.number) - уникальный номер человека
//data - дата посящения
//    kind - направление
//name - имя
//fathername - отчество
