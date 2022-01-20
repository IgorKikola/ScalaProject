// Core Part about finding a single tour for a board using the
// Warnsdorf Rule
//==============================================================

object M4b {


// !!! Copy any function you need from file knight1.scala !!!
//
// If you need any auxiliary functions, feel free to 
// implement them, but do not make any changes to the
// templates below.

type Pos = (Int, Int)    // a position on a chessboard 
type Path = List[Pos]    // a path...a list of positions

def is_legal(dim: Int, path: Path, x: Pos) : Boolean = {
   val isLegal =(x._1 >= 0) && (x._1 < dim) && (x._2 >= 0) && (x._2 < dim) && !path.contains(x) 
   isLegal
}
  
 
def legal_moves(dim: Int, path: Path, x: Pos) : List[Pos] = {
    val legalMoves = List((x._1 + 1, x._2 + 2), (x._1 + 2, x._2 + 1), (x._1 + 2, x._2 - 1), (x._1 + 1, x._2 - 2), (x._1 - 1, x._2 - 2), (x._1 - 2, x._2 - 1), (x._1 - 2, x._2 + 1), (x._1 - 1, x._2 + 2))
    legalMoves.filter(x=>is_legal(dim,path,x))
}

//(6) Complete the function that calculates a list of onward
//    moves like in (2) but orders them according to Warnsdorf’s 
//    rule. That means moves with the fewest legal onward moves 
//    should come first.


def ordered_moves(dim: Int, path: Path, x: Pos) : List[Pos] = {
    val unsortedMoves = legal_moves(dim,path,x)
    unsortedMoves.sortBy(x=>legal_moves(dim, path, x).size)
}

//(7) Complete the function that searches for a single *closed* 
//    tour using the ordered_moves function from (6). This
//    function will be tested on a 6 x 6 board. 

def first(xs: List[Pos], f: Pos => Option[Path]) : Option[Path] = xs match{
  case Nil => None
  case x::xs => if(f(x).isDefined) f(x) else first(xs,f)
}

def first_closed_tour_heuristics(dim: Int, path: Path) : Option[Path] = ???


//(8) Same as (7) but searches for *non-closed* tours. This 
//    version of the function will be called with dimensions of 
//    up to 30 * 30.

def first_tour_heuristics(dim: Int, path: Path) : Option[Path] = ???



}
