<template>
    <div id="app">
      <v-app-bar prominent src="https://cloudflare1.360gigapixels.com/pano/alienrc/00550669_vegsopano.jpg/equirect_crop_3_1/6.jpg"/>
      <v-app id="inspire" style="background-color: #F7F7F7">
        <v-layout>
          <v-navigation-drawer style="background-color: #F7F7F7" :temporary="!mini" :mini-variant.sync="mini" app permanent>
            <v-list-item>
              <v-list-item-icon >
                <v-icon> {{ this.user_icon }} </v-icon>
              </v-list-item-icon>
              <v-layout column align-center>
                <v-list-item-title  class="subtitle-1 mt-5">{{ this.full_name }}</v-list-item-title>
                <v-list-item-subtitle class="mt-5">{{ this.status }}</v-list-item-subtitle>
                <v-list-item-subtitle>{{ this.email }}</v-list-item-subtitle>
                <v-list-item-subtitle>{{ this.phone_number }}</v-list-item-subtitle>
                <ChangeUserDataDialog />
              </v-layout>
              <v-btn @click.stop="mini = !mini" icon>
                <v-icon>mdi-chevron-left</v-icon>
              </v-btn>
            </v-list-item>
            <v-divider class="mt-5"/>
            <v-list dense>
              <v-list-item v-for="item in tabs" :key="item.title" router :to="item.route" link>
                <v-list-item-icon>
                  <v-icon>{{ item.icon }}</v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title>{{ item.title }}</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list>
            <v-divider/>
            <LogOut/>
          </v-navigation-drawer>
          <v-container class="justify-center">
            <router-view  />
          </v-container>
        </v-layout>
      </v-app>
    </div>
</template>

<script>

import AuthRequest from "@/services/AuthService";
import axios from "axios";

import ChangeUserDataDialog from "./fittings/ChangeUserDataDialog"
import LogOut from "./LogOut"

export default {
  name: 'RootAdmin',
  components:{ ChangeUserDataDialog, LogOut},
  data () {
    return {
      mini: true,
      created_at: "",
      email: "",
      full_name: "",
      phone_number: "",
      status: "",
      user_icon: "fas fa-user",
      tabs: [
        {title: 'Admin', route: '/admin', icon:"fas fa-hammer"},
        {title: 'Model3D', route: '/model3d', icon:"fas fa-university"},
      ]
    }
  },
  methods: {
    async getUserData() {
      const userid = localStorage.getItem("userid");
      const response = await AuthRequest.getUser(userid);
      this.created_at = response.createdAt;
      this.email = response.emailAddress;
      this.full_name = response.fullName;
      this.status = response.status;
      this.phone_number = response.phoneNumber;
    }
  },
  mounted() {
    this.getUserData();
  }
}
</script>

<style>
</style>
