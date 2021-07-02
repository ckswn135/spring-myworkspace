package com.pcj.myworkspace.note;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

	private NoteRepository repo;

	@Autowired
	public NoteController(NoteRepository repo) {
		this.repo = repo;
	}

	@GetMapping(value = "/notes")
	public List<Note> getNoteList() {
		return repo.findAll(Sort.by("id").descending());
	}

	@GetMapping(value = "/notes/paging")
	public Page<Note> getNoteListPaging(@RequestParam int page, @RequestParam int size) {
		return repo.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
	}

	@PostMapping(value = "/notes")
	public Note addNote(@RequestBody Note note, HttpServletResponse res) {

		if (note.getMemo() == null || note.getMemo().equals("")) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		note.setCreatedTime(new Date().getTime());
		return repo.save(note);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/notes/{id}")
	public Note getNote(@PathVariable int id, HttpServletResponse res) {
		Optional<Note> note = repo.findById(id);

		if (note.isEmpty()) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return note.get();
	}

	@DeleteMapping(value = "/notes/{id}")
	public boolean removeNote(@PathVariable int id, HttpServletResponse res) {
		Optional<Note> note = repo.findById(id);

		if (note.isEmpty()) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}

		repo.deleteById(id);
		return true;
	}

	@PutMapping(value = "/notes/{id}")
	public Note modifyNote(@PathVariable int id, @RequestBody Note note, HttpServletResponse res) {
		Optional<Note> findedNote = repo.findById(id);

		if (findedNote.isEmpty()) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

		if (note.getMemo() == null && note.getMemo().equals("")) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

		Note toUpdateNote = findedNote.get();
		toUpdateNote.setMemo(note.getMemo());

		return repo.save(toUpdateNote);
	}
}
