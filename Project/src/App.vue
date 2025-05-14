<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'

</script>

<template>
  <header>
    <div class="wrapper">
      <nav>
        <RouterLink to="/home">Home</RouterLink>
        <RouterLink to="/register">Cadastrar usuário</RouterLink>
      </nav>
    </div>
  </header>

  <RouterView />
</template>

<style scoped>
header {
  display: flex;
  justify-content: center; /* Centraliza horizontalmente o conteúdo */
  align-items: center; /* Centraliza verticalmente o conteúdo */
  height: 60px; /* Define a altura do header */
  background-color: #f8f9fa; /* Cor de fundo opcional */
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

nav {
  display: flex;
  justify-content: center; /* Centraliza os itens horizontalmente */
  align-items: center; /* Centraliza verticalmente (caso necessário para altura) */
  gap: 1rem; /* Espaço entre os links */
  font-size: 1rem;
  margin: 0; /* Remove margens extras */
  padding: 1rem; /* Adiciona espaçamento interno */
  height: 100%; /* Garante que ocupe toda a altura disponível do header */
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  nav a {
    padding: 0.5rem 1rem;
    text-decoration: none;
  }
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  nav {
    justify-content: center; /* Alinha à esquerda em telas grandes */
    margin-top: 0;
  }
}
</style>
