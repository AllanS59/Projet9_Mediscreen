package com.openclassrooms.mediscreenDiabet.proxies;

import com.openclassrooms.mediscreenDiabet.beans.NoteBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${feignNotes.name}", url = "${feignNotes.url}")
public interface MediscreenNotesProxy {

    @GetMapping("/notes")
    public List<NoteBean> getNotes();

    @GetMapping("/note/{id}")
    public NoteBean getNoteById(@PathVariable(name = "id") String id);

    @GetMapping("/note")
    public List<NoteBean> getNoteByPatId(@RequestParam(name = "patId") int patId);
}
