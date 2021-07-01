package com.pcj.myworkspace.todo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

// @Entity = �����ͺ��̽��� ���̺�� ������(mapping)
// ORM(Object Relational Mapping)
// : ��ü�� ���̺��� �����Ѵ�.

// class�� ���̺��� pascal-case -> snake-case�� ����
// Todo class -> todo table
// StudentInfo class -> student_info table

// �ʵ�� �÷��� camel-case -> snake-case�� ����
// createdTime field -> created_time column

// �ڵ� ���迡 ���� �����ͺ��̽� ������ ��������� ���
// auto-migration

//Aggregation Root ��ü
//���� �Ѹ� ��ü

//��) Order �ֹ�����
//��) OrderDetail, OrderLineTime: �ֹ� ��, �ֹ� ��ǰ���
@Data
@Entity
public class Todo {

	// @Id -> ���̺��� PK(����/��ǥ �÷�)
	@Id
	// @GeneratedValue -> �ʵ� �� ���� ��� ����, IDENTITY�� �����ͺ��̽��� �ڵ��������� ���
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String memo;
	private Long createdTime;

	// JSON ���� ��ȯ�� �� �������� ����.
	// @JsonIgnore
	// OneToMany(Order-OrderDetail), OneToOne(User-Profile)
	// EAGER: ������ü ���� �� ���� ��ü ���� ����
	// LAZY: ������ü�� ����� �� ���� ��ü�� �о��. �⺻ ��ġ����
	// @OneToMany(fetch = FetchType.LAZY)
	@OneToMany
	// OneToMany(Order-OrderDetail), OneToOne(User-Profile),
	// ManyToMany(JoinColumn ���Ұ�)

	@JoinColumn(name = "todoId") // todoId(�ʵ��), todo_id(�÷���)
	private List<TodoComment> comments;
}
