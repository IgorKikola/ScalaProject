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


def occurrences(xs: List[String]): Map[String, Int] = ???


//(3) This functions calculates the dot-product of two documents
//    (list of strings). For this it calculates the occurrence
//    maps from (2) and then multiplies the corresponding occurrences. 
//    If a string does not occur in a document, the product is zero.
//    The function finally sums up all products. 


def prod(lst1: List[String], lst2: List[String]) : Int = {
    val firstDocument = occurrences(lst1)
    val secondDocument = occurrences(lst2)
    val dotProduct = {
        firstDocument.keySet.intersect(secondDocument.keySet).map(key=>key->(firstDocument(key),secondDocument(key)))
    }
    val multipliedValues= {
        for((x,(key,value))<-dotProduct.toList)yield {
            key*value
        }
    }
    multipliedValues.sum
}


//(4) Complete the functions overlap and similarity. The overlap of
//    two documents is calculated by the formula given in the assignment
//    description. The similarity of two strings is given by the overlap
//    of the cleaned strings (see (1)).  


def overlap(lst1: List[String], lst2: List[String]) : Double = {
    val d1Product = prod(lst1,lst2).toDouble
    val d1Max = prod(lst1,lst1).toDouble
    val d2Max = prod(lst2,lst2).toDouble
    val highestMax = {
        if(d1Max >= d2Max){
            d1Max
        }
        else{
            d2Max
        }
    }
    d1Product/highestMax
}

def similarity(s1: String, s2: String) : Double = {
    val firstDocument = clean(s1)
    val secondDocument = clean(s2)
    overlap(firstDocument,secondDocument)
}
}
