import Api from './Api'
import authHeader from './AuthHeader';

export default{
    updateUser: async(user) => {
        let page = 'api/user/updateUserById';
        return Api().put(page, user, { headers: authHeader() });
    },
    getUsersEmail: async() => {
        let page = 'api/user/getUsersByEmailAddress';
        return Api().get(page, { headers: authHeader() });
    },
    getUserEmail: async(emailAddress) => {
        let page = 'api/user/getUserByEmailAddress';
        return Api().post(page, emailAddress,{ headers: authHeader() });
    },
    deleteUserEmail: async(emailAddress) => {
        let page = 'api/user/deleteUserByEmailAddress';
        return Api().put(page, emailAddress , { headers: authHeader() });
    },
    addDepartment: async(department) => {
        let page = 'api/department/addDepartment';
        return Api().post(page, department , { headers: authHeader() });
    },
    getDepartmentsDepartmentName: async() => {
        let page = 'api/department/getDepartmentsByDepartmentName';
        return Api().get(page, { headers: authHeader() });
    },
    addBranch: async(branch) => {
        let page = '/api/branch/addBranch';
        return Api().post(page, branch , { headers: authHeader() });
    }
}