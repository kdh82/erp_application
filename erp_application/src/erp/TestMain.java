package erp;

import java.awt.EventQueue;

public class TestMain {

	public static void main(String[] args) {
/*		System.out.println(DBCon.getConnection());
		titleTest();
		departmentTest();
		empTest();*/
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ERPApp frame = new ERPApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

/*	private static void titleTest() {
		titleList();
		Title t = new Title(6, "인턴");
		titleIns(t);
		titleDel(t.getNo());

		titleUp(new Title(5, "말단"));
		titleUp(new Title(5, "사원"));		
	}

	private static void titleUp(Title title) {
		TitleDao.getInstance().updateItem(title);
		titleList();
	}

	private static void titleIns(Title title) {
		int res = TitleDao.getInstance().insertItem(title);
		System.out.println("추가된 객체 : " + res);
		titleList();
	}

	private static void titleDel(int idx) {
		TitleDao.getInstance().deleteItem(idx);
		System.out.println("삭제 " + idx);
		titleList();
	}

	private static void titleList() {
		List<Title> list = TitleDao.getInstance().selectByAllItems();
		for(Title t : list){
			System.out.println(t);
		}		
	}
	
	private static void empTest() {
		empList();
		Employee emp = new Employee(1004, "천사", new Title(3), new Employee(4377), 500000, new Department(1));
		empInsert(emp);
		empDel(emp.getEmpNo());
			
		empUp(new Employee(3427, "최영", new Title(3), new Employee(4377), 500000,  new Department(1)));
		empUp(new Employee(3427, "최종철", new Title(5), new Employee(3011), 1500000,  new Department(3)));		
	}

	private static void empUp(Employee employee) {
		System.out.println("변경 성공 : "+ EmployeeDao.getInstance().updateItem(employee));
		empList();
	}

	private static void empDel(int empNo) {
		EmployeeDao.getInstance().deleteItem(empNo);
		empList();		
	}

	private static void empInsert(Employee emp) {
		try {
			System.out.println("추가수 " + EmployeeDao.getInstance().insertItem(emp));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		empList();	
	}

	private static void empList() {
		for(Employee e : EmployeeDao.getInstance().selectByAllItems()){
			System.out.println(e);
		}
	}

	private static void departmentTest() {
		departmentList();
		Department dept = new Department(5, "마케팅", 6);
		departmentInsert(dept);
		departmentDel(dept.getDeptNo());
		
		departmentUp(new Department(4, "마케팅", 5));
		departmentUp(new Department(4, "총무", 7));	
	}

	private static void departmentUp(Department item) {
		DepartmentDao.getInstance().updateItem(item);
		departmentList();
	}

	private static void departmentDel(int deptNo) {
		DepartmentDao.getInstance().deleteItem(deptNo);
		departmentList();
	}

	private static void departmentInsert(Department dept) {
		System.out.println("추가수 " + DepartmentDao.getInstance().insertItem(dept));
		departmentList();
	}

	private static void departmentList() {
		for(Department dept : DepartmentDao.getInstance().selectByAllItems()){
			System.out.println(dept);
		}
	}*/

}
