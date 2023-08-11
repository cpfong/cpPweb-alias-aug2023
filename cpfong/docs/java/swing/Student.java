public class Student
{
    private String id;
    private String name;

    public Student()
    {
	id = null;
	name = null;
    }
    public Student(String pid,String pname)
    {
	id = pid;
	name = pname;
    }

    public String getId()
    {
	return id;
    }
    public String getName()
    {
	return name;
    }
    public void setId(String pid)
    {
	id = pid;
    }
    public void setName(String pname)
    {
	name = pname;
    }
}
