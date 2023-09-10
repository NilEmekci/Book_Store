package com.example.bookapi.user;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {


    USER,
    ADMIN


/*

    USER(Collections.emptySet()),
    ADMIN(Set.of(
            Permission.ADMIN_READ,
            Permission.ADMIN_UPDATE,
            Permission.ADMIN_DELETE,
            Permission.ADMIN_CREATE,
            Permission.MANAGER_CREATE,
            Permission.MANAGER_DELETE,
            Permission.MANAGER_UPDATE,
            Permission.MANAGER_READ
    )),
    MANAGER(Set.of(
            Permission.MANAGER_CREATE,
            Permission.MANAGER_DELETE,
            Permission.MANAGER_UPDATE,
            Permission.MANAGER_READ
    )) ;


    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .toList();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return authorities ;

    }*/
}
