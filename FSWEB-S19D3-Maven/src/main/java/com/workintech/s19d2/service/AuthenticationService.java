package com.workintech.s19d2.service;


import com.workintech.s19d2.entity.Member;
import com.workintech.s19d2.entity.Role;
import com.workintech.s19d2.repository.MemberRepository;
import com.workintech.s19d2.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthenticationService {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(MemberRepository memberRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Member register(String email, String password) {
        Optional<Member> foundMember = memberRepository.findByEmail(email);
        if (foundMember.isPresent()) {
            throw new RuntimeException("User with given email already exists: " + email);
        }
        String encodedPassword = passwordEncoder.encode(password);
        Role memberRole = roleRepository.findByAuthority("ADMIN")
                .orElseGet(()-> {
                    Role newRole = new Role();
                    newRole.setAuthority("ADMIN");
                    return roleRepository.save(newRole);
                });
        List<Role> roles = new ArrayList<>();
        roles.add(memberRole);

        Member member = new Member();
        member.setEmail(email);
        member.setPassword(encodedPassword);
        member.setRoles(roles);

        return memberRepository.save(member);
    }

    public Member promoteToAdmin(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        Role adminRole = roleRepository.findByAuthority("ADMIN")
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setAuthority("ADMIN");
                    return roleRepository.save(newRole);
                });

        member.addRole(adminRole);
        return memberRepository.save(member);
    }



}
