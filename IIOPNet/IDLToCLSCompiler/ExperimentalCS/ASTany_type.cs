/* Generated By:JJTree: Do not edit this line. ASTany_type.cs */

using System;

namespace parser {

public class ASTany_type : SimpleNode {
  public ASTany_type(int id) : base(id) {
  }

  public ASTany_type(IDLParser p, int id) : base(p, id) {
  }


  /** Accept the visitor. **/
  public override Object jjtAccept(IDLParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}


}
