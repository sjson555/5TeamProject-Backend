package com.Jellabo.Team_miniPj_Backend.users;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private String email;
	private String password;
	private String name;
	private String nickname;
	private String birthday;
}
