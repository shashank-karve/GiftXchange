import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import scala.io.Source

object GiftXchange {
    def GetNames(filepath: String): ArrayBuffer[String]= {
      val names = ArrayBuffer[String]()

      for(line <- Source.fromFile(filepath).getLines) {

        if (!(line.length <= 1 || line == " ")) {
          if (names.contains(line)){
            throw new Exception("Name already used!")
          }
          else {
            names += line.trim
          }

        }


      }
      names
    }

    def AssignGifts(names: List[String]): Unit={
      var a = 0
      //println("Original  Shuffled List")
      //println(names)
      for(a <- 0 to names.length - 2){
        println(s"${names(a)} gives ${names(a+1)} a gift ")
      }

      //Complete the cycle!
      println(s"${names.last} gives ${names(0)} a gift")
    }
    def main(args: Array[String]): Unit= {
      val filename = "C:\\Users\\Shashank\\IdeaProjects\\untitled\\src\\main\\Names.txt"

      val names = GetNames(filename)

      if (names.length <= 1){
        println("Please provide atleast 2 names!!")
      }
      else
        {
          //Randomly Shuffle the list
          var list_names = Random.shuffle(names.toList)

          AssignGifts(list_names)
        }


    }

}
