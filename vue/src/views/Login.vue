<template>
  <div id="login">
    <form @submit.prevent="login">
      <h1 >Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit">Sign in</button>
      <p>
      <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
body div{
  display: flex;
  justify-content: center;
  align-items: center;
  background: chocolate;
}
.centered-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  padding: 1rem;
  flex-direction: column; 
  /* items verticall */
}

form {
  width: 100%; 
  max-width: 400px; /* This will prevent the form from filling the whole page width */
  display: flex;
  flex-direction: column;
  align-items: center;
}

.form-input-group {
  margin-bottom: 1rem;
  width: 100%;
}

label {
  margin-bottom: 0.5rem;
  display: block; /* Making labels block-level so they stack above the inputs */
}

input[type="text"],
input[type="password"] {
  width: 100%; /* This ensures the inputs fill their container but not more */
}

.alert {
  padding: 0.5rem;
  border-radius: 4px;
  margin-bottom: 1rem;
  width: 100%;
  text-align: center; /* Centering the alert text */
}

.alert-error {
  background-color: #f8d7da;
  color: #721c24;
  border: 1px solid #f5c6cb;
}

.alert-success {
  background-color: #d4edda;
  color: #155724;
  border: 1px solid #c3e6cb;
}

</style>