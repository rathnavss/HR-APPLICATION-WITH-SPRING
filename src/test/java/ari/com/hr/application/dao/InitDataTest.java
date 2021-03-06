/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.com.hr.application.dao;

import ari.com.hr.application.dto.SysAuthorizationDto;
import ari.com.hr.application.model.SysAuthorization;
import ari.com.hr.application.model.SysMenus;
import ari.com.hr.application.model.SysRoles;
import ari.com.hr.application.model.SysUser;
import ari.com.hr.application.model.SysUserRoles;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ari-prasetiyo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InitDataTest {

    @Autowired
    SysRolesDao sysRolesDao;

    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    SysAuthorizationDao sysAuthorizationDao;

    @Autowired
    SysUserRolesDao sysUserRolesDao;

    @Autowired
    SysMenusDao sysMenusDao;

    @Test
    public void testAll() {
        List<SysAuthorization> listMenu = sysAuthorizationDao.getForScreenMenu(1);
//        SysAuthorization data = new SysAuthorization();
//        data.setNameMenu("a");
//        listMenu.add(data);
//        
//        data = new SysAuthorization();
//        data.setNameMenu("b");
//        listMenu.add(data);
        if (listMenu.size() > 0) {
            System.out.println("----------------------------" + listMenu.size());
        }

        for (SysAuthorization menu : listMenu) {
            System.out.println("----------------------------" + menu.getSysMenu().getMenusName());
        }
    }

    //@Before
    @Ignore
    public void initDataRoles() {
        SysRoles sysRoles = new SysRoles();
        sysRoles.setRoleName("admin");
        sysRoles = sysRolesDao.save(sysRoles);
        Assert.assertNotNull(sysRoles.getId());

        sysRoles = new SysRoles();
        sysRoles.setRoleName("approval");
        sysRoles = sysRolesDao.save(sysRoles);
        Assert.assertNotNull(sysRoles.getId());

        sysRoles = new SysRoles();
        sysRoles.setRoleName("user");
        sysRoles = sysRolesDao.save(sysRoles);
        Assert.assertNotNull(sysRoles.getId());

        sysRoles = new SysRoles();
        sysRoles.setRoleName("public");
        sysRoles = sysRolesDao.save(sysRoles);
        Assert.assertNotNull(sysRoles.getId());
    }

    //@Test
    @Ignore
    public void initDataSysAuthorization() {

        Long idRoles = sysRolesDao.getIdByName("admin");
        Assert.assertNotNull(idRoles);
        SysAuthorization sysAuthorization = new SysAuthorization();

        //sysAuthorization.setParent(null);
        //sysAuthorization.setSysRoles(idRoles);
        sysAuthorizationDao.updateSysRoleId(idRoles, null);
        sysAuthorizationDao.deleteAll();
        
        //Parent
        sysAuthorization.setSysMenu(1);
        sysAuthorization.setIsDelete(true);
        sysAuthorization.setIsInsert(true);
        sysAuthorization.setIsRead(true);
        sysAuthorization.setIsUpdate(true);
        sysAuthorization.setParent(null);
        sysAuthorization.setSysRoles(idRoles);
        SysAuthorization parentDashBoard = sysAuthorizationDao.save(sysAuthorization);
        Assert.assertNotNull(sysAuthorization.getId());

        //Parent child
        sysAuthorization = new SysAuthorization();
        sysAuthorization.setSysMenu(2);
        sysAuthorization.setIsDelete(true);
        sysAuthorization.setIsInsert(true);
        sysAuthorization.setIsRead(true);
        sysAuthorization.setIsUpdate(true);
        sysAuthorization.setSysRoles(idRoles);
        sysAuthorization.setParent(parentDashBoard);
        sysAuthorizationDao.save(sysAuthorization);
        Assert.assertNotNull(sysAuthorization.getId());

        //Parent child
        sysAuthorization = new SysAuthorization();
        sysAuthorization.setSysMenu(3);
        sysAuthorization.setIsDelete(true);
        sysAuthorization.setIsInsert(true);
        sysAuthorization.setIsRead(true);
        sysAuthorization.setIsUpdate(true);
        sysAuthorization.setSysRoles(idRoles);
        sysAuthorization.setParent(parentDashBoard);
        sysAuthorizationDao.save(sysAuthorization);
        Assert.assertNotNull(sysAuthorization.getId());

        //Parent
        sysAuthorization = new SysAuthorization();
        sysAuthorization.setSysMenu(4);
        sysAuthorization.setIsDelete(true);
        sysAuthorization.setIsInsert(true);
        sysAuthorization.setIsRead(true);
        sysAuthorization.setIsUpdate(true);
        sysAuthorization.setParent(null);
        sysAuthorization.setSysRoles(idRoles);
        SysAuthorization parentUtility = sysAuthorizationDao.save(sysAuthorization);
        Assert.assertNotNull(sysAuthorization.getId());

        //Parent child
        sysAuthorization = new SysAuthorization();
        sysAuthorization.setSysMenu(5);
        sysAuthorization.setIsDelete(true);
        sysAuthorization.setIsInsert(true);
        sysAuthorization.setIsRead(true);
        sysAuthorization.setIsUpdate(true);
        sysAuthorization.setParent(parentUtility);
        sysAuthorization.setSysRoles(idRoles);
        SysAuthorization parentSettingUser = sysAuthorizationDao.save(sysAuthorization);
        Assert.assertNotNull(sysAuthorization.getId());

        //Parent Parent child
        sysAuthorization = new SysAuthorization();
        sysAuthorization.setSysMenu(6);
        sysAuthorization.setIsDelete(true);
        sysAuthorization.setIsInsert(true);
        sysAuthorization.setIsRead(true);
        sysAuthorization.setIsUpdate(true);
        sysAuthorization.setParent(parentSettingUser);
        sysAuthorization.setSysRoles(idRoles);
        sysAuthorizationDao.save(sysAuthorization);
        Assert.assertNotNull(sysAuthorization.getId());

        //Parent Parent child
        sysAuthorization = new SysAuthorization();
        sysAuthorization.setSysMenu(7);
        sysAuthorization.setIsDelete(true);
        sysAuthorization.setIsInsert(true);
        sysAuthorization.setIsRead(true);
        sysAuthorization.setIsUpdate(true);
        sysAuthorization.setParent(parentSettingUser);
        sysAuthorization.setSysRoles(idRoles);
        sysAuthorizationDao.save(sysAuthorization);
        Assert.assertNotNull(sysAuthorization.getId());

        //Parent child
        sysAuthorization = new SysAuthorization();
        sysAuthorization.setSysMenu(8);
        sysAuthorization.setIsDelete(true);
        sysAuthorization.setIsInsert(true);
        sysAuthorization.setIsRead(true);
        sysAuthorization.setIsUpdate(true);
        sysAuthorization.setParent(parentUtility);
        sysAuthorization.setSysRoles(idRoles);
        sysAuthorizationDao.save(sysAuthorization);
        Assert.assertNotNull(sysAuthorization.getId());

        //Parent child
        sysAuthorization = new SysAuthorization();
       sysAuthorization.setSysMenu(9);
        sysAuthorization.setIsDelete(true);
        sysAuthorization.setIsInsert(true);
        sysAuthorization.setIsRead(true);
        sysAuthorization.setIsUpdate(true);
        sysAuthorization.setParent(parentUtility);
        sysAuthorization.setSysRoles(idRoles);
        sysAuthorizationDao.save(sysAuthorization);
        Assert.assertNotNull(sysAuthorization.getId());

        //Parent child
        sysAuthorization = new SysAuthorization();
        sysAuthorization.setSysMenu(10);
        sysAuthorization.setIsDelete(true);
        sysAuthorization.setIsInsert(true);
        sysAuthorization.setIsRead(true);
        sysAuthorization.setIsUpdate(true);
        sysAuthorization.setParent(parentUtility);
        sysAuthorization.setSysRoles(idRoles);
        sysAuthorizationDao.save(sysAuthorization);
        Assert.assertNotNull(sysAuthorization.getId());
    }

    //@Test
    public void initDataSysUser() {
        sysUserRolesDao.deleteAll();
        sysUserDao.deleteAll();

        Long idSysRoles = sysRolesDao.getIdByName("admin");
        Assert.assertNotNull(idSysRoles);

        SysUser sysUser = new SysUser();
        sysUser.setUsername("ari");
        sysUser.setPassword("1234");
        sysUser.setEmail("prasetiyooo@gmail.com");
        sysUser.setIsActive(true);
        sysUser.setNoHp("085645480401");
        sysUser = sysUserDao.save(sysUser);
        Assert.assertNotNull(sysUser.getId());

        SysUserRoles sysUserRoles = new SysUserRoles();
        sysUserRoles.setSysUser(sysUser);
        sysUserRoles.setSysRoles(idSysRoles);
        sysUserRolesDao.save(sysUserRoles);
        Assert.assertNotNull(sysUserRoles.getId());

        sysUser = new SysUser();
        sysUser.setUsername("ari prasetiyo");
        sysUser.setPassword("12345");
        sysUser.setEmail("prasetiyooo2@gmail.com");
        sysUser.setIsActive(true);
        sysUser.setNoHp("085645480401");
        sysUser = sysUserDao.save(sysUser);
        Assert.assertNotNull(sysUser.getId());

        idSysRoles = sysRolesDao.getIdByName("approval");
        sysUserRoles = new SysUserRoles();
        sysUserRoles.setSysUser(sysUser);
        sysUserRoles.setSysRoles(idSysRoles);
        sysUserRolesDao.save(sysUserRoles);
        Assert.assertNotNull(sysUserRoles.getId());

        idSysRoles = sysRolesDao.getIdByName("public");
        sysUserRoles = new SysUserRoles();
        sysUserRoles.setSysUser(sysUser);
        sysUserRoles.setSysRoles(idSysRoles);
        sysUserRolesDao.save(sysUserRoles);
        Assert.assertNotNull(sysUserRoles.getId());

        sysUser = new SysUser();
        sysUser.setUsername("public");
        sysUser.setPassword("public");
        sysUser.setEmail("public@gmail.com");
        sysUser.setIsActive(true);
        sysUser.setNoHp("085645480401");
        sysUser = sysUserDao.save(sysUser);
        Assert.assertNotNull(sysUser.getId());

        idSysRoles = sysRolesDao.getIdByName("public");
        sysUserRoles = new SysUserRoles();
        sysUserRoles.setSysUser(sysUser);
        sysUserRoles.setSysRoles(idSysRoles);
        sysUserRolesDao.save(sysUserRoles);
        Assert.assertNotNull(sysUserRoles.getId());

    }

    @PersistenceContext
    public EntityManager em;

    @Ignore
    @Transactional
    public void readRolesAndDipatcherUrl() {
//        SysAuthorizationImpl call = new SysAuthorizationImpl();
//        call.test();

        Iterable<SysAuthorizationDto> sysAuthorizations = sysAuthorizationDao.listRolenameAndDispatcherUrl();
        for (SysAuthorizationDto sysAuthorization : sysAuthorizations) {
            System.out.print(sysAuthorization.getRoleName());
            System.out.println(":" + sysAuthorization.getPatternDispatcherUrl());
        }

//        List<SysAuthorizationDto> sysAuthorizations = (List<SysAuthorizationDto>) em.createQuery("select a.patternDispatcherUrl as patternDispatcherUrl, b.roleName as roleName from SysAuthorization a left join a.sysRoles b ").getResultList();
//        for (SysAuthorizationDto sysAuthorization : sysAuthorizations) {
//            System.out.print(sysAuthorization.getRoleName());
//            System.out.println(":" + sysAuthorization.getPatternDispatcherUrl());
//        }
    }

    @Ignore
    public void insertDataMenu() {
        SysMenus sysMenus = new SysMenus();
        sysMenus.setMenusName("Dashboard");
        sysMenus.setUrl(null);
        Long id = sysMenusDao.save(sysMenus).getId();
        Assert.assertNotNull(id);

        sysMenus = new SysMenus();
        sysMenus.setMenusName("Dashboard V1");
        sysMenus.setUrl("/Dashboard/V1");
        id = sysMenusDao.save(sysMenus).getId();
        Assert.assertNotNull(id);
        
        sysMenus = new SysMenus();
        sysMenus.setMenusName("Dashboard V2");
        sysMenus.setUrl("/Dashboard/V2");
        id = sysMenusDao.save(sysMenus).getId();
        Assert.assertNotNull(id);

    }
}
