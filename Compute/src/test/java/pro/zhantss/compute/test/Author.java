package pro.zhantss.compute.test;

public class Author {

	private String name;

	private String sex;

	private Integer age;

	public Author() {
		super();
	}

	public Author(String name, String sex, Integer age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}

}
