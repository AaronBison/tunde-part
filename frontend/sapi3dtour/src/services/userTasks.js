import Api from './Api'
import authHeader from './AuthHeader';

export default{
    updateAdmin: async(admin) => {
        let page = 'user/updateAdminData';
        return Api().put(page, admin, { headers: authHeader() });
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
    }
}