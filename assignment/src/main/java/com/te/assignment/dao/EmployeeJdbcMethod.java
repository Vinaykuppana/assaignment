package com.te.assignment.dao;


	import java.sql.*;
	import java.util.Scanner;

	public class EmployeeJdbcMethod {
		
		Scanner scanner = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/assignment";
		String user = "root";
		String password = "root";
		
		public void allData() {
			Connection connection=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				try {
					connection = DriverManager.getConnection(url, user, password);
					String query = "select * from employee";
					PreparedStatement preparedStatement=connection.prepareStatement(query);
					ResultSet resSet=preparedStatement.executeQuery(query);
					while(resSet.next()) {
						System.out.print(resSet.getInt(1)+ " ");
						System.out.print(resSet.getString(2)+ " ");
						System.out.println(resSet.getInt(3));
					}
					
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		public void deleteData() {
			Connection connection = null;
			System.out.println("enter the id to delete");
			int id = scanner.nextInt();
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				try {
					connection = DriverManager.getConnection(url, user, password);
					String query = "delete from employee where id=?";
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, id);
					int execute = preparedStatement.executeUpdate();

					System.out.println(execute+" rows deleted");
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

			finally {
				try {
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return;

		}

		public void updateData() {
			Connection connection = null;
			System.out.println("enter the name to alter by id");
			String name = scanner.next();
			int id=scanner.nextInt();
			System.out.println(id);
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				try {
					connection = DriverManager.getConnection(url, user, password);
					String query = "update employee set name=? where id=?";
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, name);
					preparedStatement.setDouble(2, id);
					int execute = preparedStatement.executeUpdate();

					System.out.println(execute+" updated successfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

			finally {
				try {
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return;

		}


		public void insertData() {
			Connection connection = null;
			System.out.println("enter the name and deptno");
			String name = scanner.next();
			int deptno = scanner.nextInt();
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				try {
					connection = DriverManager.getConnection(url, user, password);
					String query = "insert into employee(name,deptno) values(?,?)";
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, name);
					preparedStatement.setLong(2, deptno);
					int execute = preparedStatement.executeUpdate();

					System.out.println(execute+"inserted successfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

			finally {
				try {
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			

		}


}
