package com.forcen.gestionimmobliere.services;

import java.util.List;

import com.forcen.gestionimmobliere.web.dtos.UtilisateurDTO;

public interface UtilisateurService {
    public UtilisateurDTO saveUtilisateur(UtilisateurDTO utilisateurDTO);
    
<<<<<<< HEAD:src/main/java/com/forcen/gestionimmobliere/services/UtilisateurService.java
    public UtilisateurDTO updateUtilisateur(UtilisateurDTO utilisateurDTO);

    public String deleteUtilisateur(Long id);

    public UtilisateurDTO findById(Long id);
=======
    UtilisateurDTO updateUtilisateur(UtilisateurDTO utilisateurDTO);
    String deleteUtilisateur(Long id);
    UtilisateurDTO findById(Long id);
>>>>>>> d9fabef370e300d077a6c36b90cf0ec9b705db27:mangane-wks-gest-immo-bf688963fce9/src/main/java/com/forcen/gestionimmobliere/services/UtilisateurService.java
    
    public List<UtilisateurDTO> findAll();
}
