package com.pcj.myworkspace.memo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

	Page<Note> findByMemo(Pageable page, String memo);

	Page<Note> findByMemoContaining(Pageable page, String memo);
}
