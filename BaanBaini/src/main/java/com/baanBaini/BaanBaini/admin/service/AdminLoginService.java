package com.baanBaini.BaanBaini.admin.service;

import com.baanBaini.BaanBaini.admin.model.dto.AdminDTO;

public interface AdminLoginService {
    AdminDTO addAdmin(AdminDTO adminDTO);
    AdminDTO getAdminByEmail(String email);
    AdminDTO getAdminByPublicUserId(String publicUserId);
}
