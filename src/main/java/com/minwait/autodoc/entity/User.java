package com.minwait.autodoc.entity;

import lombok.*;

/**
 * User Entity
 *
 * @author by xunmi
 * @version 1.0
 * 2020/3/9 15:17
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @NonNull
    private Long id;
    private String name;
    private String username;
    private String password;
}
