package hu.sandor.anima.animabackend.character;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    // creator (User) -> id mezője
    List<Character> findByCreator_Id(Long creatorId);
}
