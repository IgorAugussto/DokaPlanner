<script setup lang="ts">
import WelcomeItem from './WelcomeItem.vue'
import DocumentationIcon from './icons/IconDocumentation.vue'

</script>

<template>
  <WelcomeItem>
    <template #icon>
      <DocumentationIcon />
    </template>
    <template #heading>Documentation</template>
    <RouterLink to="/login" class="link">Login</RouterLink>
    <RouterLink to="/register" class="link">Cadastrar</RouterLink>
  </WelcomeItem>
</template>
