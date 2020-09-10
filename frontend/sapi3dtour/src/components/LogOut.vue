<template>
    <v-list-item dense router link>
        <v-list-item-icon>
            <v-icon @click="logOut">{{ logout.icon }}</v-icon>
        </v-list-item-icon>
        <v-list-item-content>
            <v-list-item-title @click="logOut" >{{ logout.title }}</v-list-item-title>
        </v-list-item-content>
    </v-list-item> 
</template>

<script>


export default {
  name: 'LogOut',
  data () {
    return {
      logout: { title: "Kilépés", icon: "fas fa-power-off" }
    }
  },
  methods: {
    logOut(){
      localStorage.removeItem('userid');
      localStorage.removeItem('token');
      this.$router.push('/model3d')
    }
  }
}
</script>

<style>
</style>
