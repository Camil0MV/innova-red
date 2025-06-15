# 🗄️ Script de Base de Datos – InnovaRed

Este archivo contiene la estructura (schema) de la base de datos **InnovaRed**, diseñada para gestionar información sobre personas y sus emprendimientos o innovaciones.

---

## 📦 Contenido

El script `estructura_innovared.sql` incluye:

- Creación de la base de datos `innovared_db`
- Tablas:
  - `person`
  - `entrepreneurship`
- Claves primarias y únicas
- Tipos de datos y restricciones básicas

---

## 🚀 Cómo usar el script

### Opción 1: Desde MySQL Workbench

1. Abre **MySQL Workbench**.
2. Conéctate a tu servidor local o remoto.
3. Ve a **File > Open SQL Script** y selecciona `estructura_innovared.sql`.
4. Haz clic en el rayo ⚡ (Ejecutar).

### Opción 2: Desde línea de comandos

```bash
mysql -u tu_usuario -p < ruta/al/archivo/estructura_innovared.sql
```

Ejemplo si estás en la carpeta raíz del proyecto:

```bash
mysql -u root -p < db/estructura_innovared.sql
```

---

## ⚠️ Requisitos

- MySQL 8.0 o superior
- Acceso con permisos para crear bases de datos y tablas

---

## 📁 Ubicación sugerida

Coloca este archivo dentro de una carpeta `db/` dentro de tu proyecto, por ejemplo:

```
innova-red/
├── backend/
├── frontend/
├── db/
│   └── estructura_innovared.sql
│   └── README.md
```

---

## ✅ Siguiente paso

Una vez ejecutado el script:

- Verifica que la base de datos `innovared_db` esté disponible en tu servidor.
- Asegúrate de que tu backend esté configurado para conectarse correctamente a esta base de datos, ya sea mediante `application.properties`, `.env`, o archivo equivalente.

---

## 📝 ¿Y si agregas datos de prueba?

Si planeas agregar un archivo con datos (`data_innovared.sql`), recuerda incluir instrucciones adicionales para ejecutarlo después de la estructura:

```bash
mysql -u root -p innovared_db < db/data_innovared.sql
```

---

## 📌 Notas

Este archivo contiene únicamente la **estructura**, sin datos de prueba por ahora. Asegúrate de tener tus credenciales y configuraciones actualizadas antes de ejecutar cualquier script de base de datos en producción.

---