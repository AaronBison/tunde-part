<template>
    <div id="app">
      <v-app id="inspire">
      <v-app-bar color="#2B405D" dark prominent class="justify-center">
        <v-app-bar-title>3D virtuális túra a Sapientia Erdélyi Magyar Tudományegyetem Marosvásárhely-i karán</v-app-bar-title>
        <v-spacer></v-spacer>
        <LoginDialog />
        <template v-slot:extension>
          <v-tabs align-with-title dark >
            <v-tab v-for="item in tabs" :key="item.title" router :to="item.route" link>{{ item.title }}</v-tab>
          </v-tabs>
        </template>
      </v-app-bar>
      <v-sheet id="scrolling-techniques-3" class="overflow-y-auto">
        <v-container>
          <router-view/>
        </v-container>
      </v-sheet>
      </v-app>
    </div>
</template>

<script>

import LoginDialog from "./dialogs/LoginDialog"

export default {
  name: 'RootEvery',
  components: {LoginDialog},
  data () {
    return {
      tabs: [
        {title: 'Model3D', route: '/model3d', icon:"fas fa-university"},
        {title: 'Fontos egyetemi helyek', route: '/department', icon:"fas fa-book-reader"},
      ]
    }
  }
}
</script>

<style>
    #card {
        background-color: #E1E1DE;
        color: #2B405D;
    }
</style>
