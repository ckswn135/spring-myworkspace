package com.pcj.myworkspace.todo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

// @Entity = 데이터베이스의 테이블과 연결함(mapping)
// ORM(Object Relational Mapping)
// : 객체와 테이블을 맵핑한다.

// class와 테이블은 pascal-case -> snake-case로 맵핑
// Todo class -> todo table
// StudentInfo class -> student_info table

// 필드와 컬럼은 camel-case -> snake-case로 맵핑
// createdTime field -> created_time column

// 코드 설계에 따라서 데이터베이스 구조가 만들어지는 방법
// auto-migration

//Aggregation Root 객체
//집합 뿌리 객체

//예) Order 주문정보
//예) OrderDetail, OrderLineTime: 주문 상세, 주문 제품목록
@Data
@Entity
public class Todo {

	// @Id -> 테이블의 PK(유일/대표 컬럼)
	@Id
	// @GeneratedValue -> 필드 값 생성 방법 정의, IDENTITY는 데이터베이스의 자동증가값을 사용
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String memo;
	private Long createdTime;

	// JSON 으로 변환할 때 보여주지 않음.
	// @JsonIgnore
	// OneToMany(Order-OrderDetail), OneToOne(User-Profile)
	// EAGER: 상위객체 읽을 때 하위 객체 같이 읽음
	// LAZY: 하위객체를 사용할 때 하위 객체를 읽어옴. 기본 페치전략
	// @OneToMany(fetch = FetchType.LAZY)
	@OneToMany
	// OneToMany(Order-OrderDetail), OneToOne(User-Profile),
	// ManyToMany(JoinColumn 사용불가)

	@JoinColumn(name = "todoId") // todoId(필드명), todo_id(컬럼명)
	private List<TodoComment> comments;
}
