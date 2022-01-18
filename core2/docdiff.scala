// Core Part 2 about Code Similarity
//===================================


object C2 { 


//(1) Complete the clean function below. It should find
//    all words in a string using the regular expression
//    \w+  and the library function 
//
//         some_regex.findAllIn(some_string)
//
//    The words should be Returned as a list of strings.


def clean(s: String) : List[String] = {
    val words = """\w+""".r.findAllIn(s).toList
    words
}
  


//(2) The function occurrences calculates the number of times  
//    strings occur in a list of strings. These occurrences should 
//    be calculated as a Map from strings to integers.


def occurrences(xs: List[String]): Map[String, Int] = {
    val myList = xs.groupBy(identity).mapValues(_.size)
    myList
}


//(3) This functions calculates the dot-product of two documents
//    (list of strings). For this it calculates the occurrence
//    maps from (2) and then multiplies the corresponding occurrences. 
//    If a string does not occur in a document, the product is zero.
//    The function finally sums up all products. 


def prod(lst1: List[String], lst2: List[String]) : Int = ???


//(4) Complete the functions overlap and similarity. The overlap of
//    two documents is calculated by the formula given in the assignment
//    description. The similarity of two strings is given by the overlap
//    of the cleaned strings (see (1)).  


def overlap(lst1: List[String], lst2: List[String]) : Double = ???

def similarity(s1: String, s2: String) : Double = ???
}
