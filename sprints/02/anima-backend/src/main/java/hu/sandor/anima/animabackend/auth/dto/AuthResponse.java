package hu.sandor.anima.animabackend.auth.dto;

public class AuthResponse {

    private Long userId;
    private String username;

    public AuthResponse(Long userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public Long getUserId() { return userId; }
    public String getUsername() { return username; }
}

