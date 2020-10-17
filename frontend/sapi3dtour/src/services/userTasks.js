import Api from './Api'
import authHeader from './AuthHeader';

export default{
    updateAdmin: async(admin) => {
        let page = 'user/updateAdminData';
        return Api().put(page, admin, { headers: authHeader() });
    },
    getUsersEmail: async() => {
        let page = '/user/returnUserList';
        return Api().get(page, { headers: authHeader() });
    },
    getUserEmail: async(emailAddress) => {
        let page = '/user/returnUserEmail?emailAddress=' + emailAddress;
        return Api().get(page, { headers: authHeader() });
    },
    deleteUserEmail: async(emailAddress) => {
        let page = '/user/deleteUser?emailAddress=' + emailAddress;
        return Api().put(page, emailAddress , { headers: authHeader() });
    }
}