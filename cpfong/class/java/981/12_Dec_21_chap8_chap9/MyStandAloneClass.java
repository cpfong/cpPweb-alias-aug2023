// will be called by other
// note: iPlusP is a PRIVATE function, so cannot call by outsite

public class MyStandAloneClass{
	private int i;

	public  void iPlusIn(int in){ i += in; }
	private void iPlusP (int in){ i -= in; }
//	public  void iPlusP (int in){ i -= in; }
	public  void i_am_inside_so_can_call_pri(){ iPlusP(2); }
}

