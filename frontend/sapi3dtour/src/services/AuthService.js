import Api from './Api'
import authHeader from './AuthHeader';

export default{
    getUser: async (id) => {
        let page = 'user/returnAdmin?id=' + String(id);
        return (await Api().get(page, { headers: authHeader() })).data;
    },
    addNewAdmin: async(newAdmin) => {
        let page = 'user/addNewAdmin';
        return Api().post(page, newAdmin);
    },
    updateAdmin: async(admin) => {
        let page = 'user/updateAdminData';
        return Api().put(page, admin);
    },
    loginVerification: async(user) => {
        let page = 'user/authenticate';
        return Api().post(page, user);
    }
}