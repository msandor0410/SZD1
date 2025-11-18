package hu.sandor.anima.animabackend.character;

import hu.sandor.anima.animabackend.character.dto.CharacterRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/characters")
public class CharacterController {


    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    // GET – list all of current user
    @GetMapping
    public List<Character> all(@RequestHeader("userId") Long userId) {
        return service.getAllByUser(userId);
    }

    // GET one
    @GetMapping("/{id}")
    public Character one(@PathVariable Long id, @RequestHeader("userId") Long userId) {
        return service.getOne(id, userId);
    }

    // CREATE
    @PostMapping
    public Character create(@RequestHeader("userId") Long userId,
                            @RequestBody CharacterRequest req) {
        return service.create(userId, req);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Character update(@PathVariable Long id,
                            @RequestHeader("userId") Long userId,
                            @RequestBody CharacterRequest req) {
        return service.update(id, userId, req);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, @RequestHeader("userId") Long userId) {
        service.delete(id, userId);
    }
}

