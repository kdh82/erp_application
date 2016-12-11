package erp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erp.dao.DepartmentDao;
import erp.dao.EmployeeDao;
import erp.dao.TitleDao;
import erp.dto.Department;
import erp.dto.Employee;
import erp.dto.Title;
import erp.list.DepartmentList;
import erp.list.EmployeeList;
import erp.list.TitleList;
import erp.view.DepartmentView;
import erp.view.EmployeeView;
import erp.view.TitleView;

@SuppressWarnings("serial")
public class ERPApp extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private TitleList titleList;
	private DepartmentList deptList;
	private EmployeeList empList;
	
	public ERPApp() {
		setTitle("회사관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 364);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		addMenuTitle();
		addMenuDepartment();
		addMenuEmployee();
	}

	private void changePanel(JPanel p) {
		setContentPane(p);
		revalidate();
		pack();
	}

	private void addMenuEmployee() {
		JMenu mnEmployee = new JMenu("사원");
		menuBar.add(mnEmployee);

		JMenuItem mntmAddEmployee = new JMenuItem(new AbstractAction("사원 추가") {
			@Override
			public void actionPerformed(ActionEvent e) {
				EmployeeView empView = new EmployeeView(true);
				changePanel(empView);
			}
		});
		mnEmployee.add(mntmAddEmployee);

		JMenuItem mntmUpdateEmployee = new JMenuItem(new AbstractAction("사원 수정") {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Employee> lists = EmployeeDao.getInstance().selectByAllItems();
				Employee res = (Employee) JOptionPane.showInputDialog(null, "수정할 항목선택", "사원 수정",
						JOptionPane.INFORMATION_MESSAGE, null, lists.toArray(), EmployeeDao.getInstance().selectByItem(3));
				if (res == null) {
					return;
				}
				EmployeeView empView = new EmployeeView(false);
				empView.setObject(res);
				changePanel(empView);
			}
		});
		mnEmployee.add(mntmUpdateEmployee);

		JMenuItem mntmDelEmployee = new JMenuItem(new AbstractAction("사원 삭제") {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Employee> lists = EmployeeDao.getInstance().selectByAllItems();
				Employee res = (Employee) JOptionPane.showInputDialog(null, "삭제할 항목선택", "사원 삭제",
						JOptionPane.INFORMATION_MESSAGE, null, lists.toArray(), EmployeeDao.getInstance().selectByItem(3));
				if (res == null) {
					return;
				}
				EmployeeDao.getInstance().deleteItem(res.getEmpNo());
				JOptionPane.showMessageDialog(null, "삭제 되었습니다.");
				if (empList != null){
					empList.reload();
				}
			}
		});
		mnEmployee.add(mntmDelEmployee);

		JMenuItem mntmListEmployee = new JMenuItem(new AbstractAction("사원 목록") {
			@Override
			public void actionPerformed(ActionEvent e) {
				empList = new EmployeeList("사원");
				changePanel(empList);
			}
		});
		mnEmployee.add(mntmListEmployee);			
	}
	
	private void addMenuDepartment() {
		JMenu mnDepartment = new JMenu("부서");
		menuBar.add(mnDepartment);

		JMenuItem mntmAddDepartment = new JMenuItem(new AbstractAction("부서 추가") {
			@Override
			public void actionPerformed(ActionEvent e) {
				DepartmentView deptView = new DepartmentView(true);
				changePanel(deptView);
			}
		});
		mnDepartment.add(mntmAddDepartment);

		JMenuItem mntmUpdateDepartment = new JMenuItem(new AbstractAction("부서 수정") {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Department> lists = DepartmentDao.getInstance().selectByAllItems();
				Department res = (Department) JOptionPane.showInputDialog(null, "수정할 항목선택", "부서 수정",
						JOptionPane.INFORMATION_MESSAGE, null, lists.toArray(), DepartmentDao.getInstance().selectByItem(3));
				if (res == null) {
					return;
				}
				DepartmentView deptView = new DepartmentView(false);
				deptView.setObject(res);
				changePanel(deptView);
			}
		});
		mnDepartment.add(mntmUpdateDepartment);

		JMenuItem mntmDelDepartment = new JMenuItem(new AbstractAction("부서 삭제") {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Department> lists = DepartmentDao.getInstance().selectByAllItems();
				Department res = (Department) JOptionPane.showInputDialog(null, "삭제할 항목선택", "부서 삭제",
						JOptionPane.INFORMATION_MESSAGE, null, lists.toArray(), DepartmentDao.getInstance().selectByItem(3));
				if (res == null) {
					return;
				}
				DepartmentDao.getInstance().deleteItem(res.getDeptNo());
				JOptionPane.showMessageDialog(null, "삭제 되었습니다.");
				if (deptList != null){
					deptList.reload();
				}
			}
		});
		mnDepartment.add(mntmDelDepartment);

		JMenuItem mntmListDepartment = new JMenuItem(new AbstractAction("부서 목록") {
			@Override
			public void actionPerformed(ActionEvent e) {
				deptList = new DepartmentList("부서");
				changePanel(deptList);
			}
		});
		mnDepartment.add(mntmListDepartment);		
	}

	private void addMenuTitle() {
		JMenu mnTitle = new JMenu("직책");
		menuBar.add(mnTitle);

		JMenuItem mntmAddTitle = new JMenuItem(new AbstractAction("직책 추가") {
			@Override
			public void actionPerformed(ActionEvent e) {
				TitleView tv = new TitleView(true);
				changePanel(tv);
			}
		});
		mnTitle.add(mntmAddTitle);

		JMenuItem mntmUpdateTitle = new JMenuItem(new AbstractAction("직책 수정") {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Title> lists = TitleDao.getInstance().selectByAllItems();
				Title res = (Title) JOptionPane.showInputDialog(null, "수정할 항목선택", "직책 수정",
						JOptionPane.INFORMATION_MESSAGE, null, lists.toArray(), TitleDao.getInstance().selectByItem(3));
				if (res == null) {
					return;
				}
				TitleView tv = new TitleView(false);
				tv.setObject(res);
				changePanel(tv);
			}
		});
		mnTitle.add(mntmUpdateTitle);

		JMenuItem mntmDelTitle = new JMenuItem(new AbstractAction("직책 삭제") {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Title> lists = TitleDao.getInstance().selectByAllItems();
				Title res = (Title) JOptionPane.showInputDialog(null, "삭제할 항목선택", "직책 삭제",
						JOptionPane.INFORMATION_MESSAGE, null, lists.toArray(), TitleDao.getInstance().selectByItem(3));
				if (res == null) {
					return;
				}
				TitleDao.getInstance().deleteItem(res.getNo());
				JOptionPane.showMessageDialog(null, "삭제 되었습니다.");
				if (titleList != null){
					titleList.reload();
				}
			}
		});
		mnTitle.add(mntmDelTitle);

		JMenuItem mntmListTitle = new JMenuItem(new AbstractAction("직책 목록") {

			@Override
			public void actionPerformed(ActionEvent e) {
				titleList = new TitleList("직책");
				changePanel(titleList);
			}
		});
		mnTitle.add(mntmListTitle);
	}

}
