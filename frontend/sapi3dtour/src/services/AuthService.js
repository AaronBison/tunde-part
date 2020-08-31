import Api from './Api'

export default{
    getUser: async (id) => {
        let page = 'admin/returnAdmin?id=' + String(id);
        return (await Api().get(page)).data;
    },
    addNewAdmin: async(newAdmin) => {
        let page = 'admin/addNewAdmin';
        return Api().post(page, newAdmin);
    },
    updateAdmin: async(admin) => {
        let page = 'admin/updateAdminData';
        return Api().put(page, admin);
    },
    loginVerification: async(user) => {
        let page = 'admin/loginUser';
        return Api().post(page, user);
    }
}