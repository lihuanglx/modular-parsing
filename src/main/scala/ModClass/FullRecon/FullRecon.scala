package ModClass.FullRecon

import ModClass.Recon.Recon
import ModClass.FullUntyped.Let
import ModClass.Lib._


object FullRecon {

  trait Parser extends Recon.Parser with Let.Parser {

    val pFullReconE: PackratParser[Term] = pReconE ||| pLetE
    val pFullReconT: PackratParser[Ty] = pReconT

    override val pE: PackratParser[Term] = pFullReconE
    override val pT: PackratParser[Ty] = pFullReconT
  }

}

object TestFullRecon {

  def parseAndPrint(inp: String): Unit = {
    val p = new FullRecon.Parser {}
    println(parse(p.pE)(inp))
  }

}