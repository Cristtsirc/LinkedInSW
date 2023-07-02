import subsystemOfProfiles.*;
import subsystemOfPublications.*;
import subsystemOfSearch.APPLICANTFILTER;
import subsystemOfSearch.VACANCYFITLER;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("*******************************************************************************************\n" +
                "**********************************  L I N K E D  I N **************************************\n" +
                "*******************************************************************************************\n");
        //ESTOS VAN A SER PRUEBAS EN BRUTO
        //Crear perfil
        Profile normalUser = new User("Mengano", "Fulano", "Ingenieria software", "0123456789", "Ecuador", "meganito01@holi.com.ec");
        Profile enterpriseUser = new Enterprise("ImportadoraBWCC", "Comercio", "www.empresacomercio.com.ec", "Quito-Ecuador", "05-30-2000", "Somos una empresa dedicada al comercio, eligenos para trabajar");
        ((Enterprise) enterpriseUser).publicateVacant("Gerente Call", "Gerente Call Center de Sangolqui");
        ((Enterprise) enterpriseUser).publicateVacant("Jefe De Departamento de Marketing", "Se necesita de un maketologo");
        //DATOS NO QUEMADOS

        System.out.println("Cree una cuenta: ");
        Scanner sc = new Scanner(System.in);
        String menu = "\n1. Tipo Usuario\t 2. Tipo empresa\t";
        System.out.println(menu);
        int opcion = Integer.parseInt(sc.nextLine());

        switch (opcion) {
            case 1:
                System.out.println("Ingrese su nombre: ");
                String firstName = sc.nextLine();
                System.out.println("Ingrese su apellido: ");
                String lastName = sc.nextLine();
                System.out.println("Cual es su grado universitario (ejemplo: Primero): ");
                String universityDegree = sc.nextLine();
                System.out.println("Ingrese su numero telefonico: ");
                String cellphoneNumber = sc.nextLine();
                System.out.println("Cual es su pais de residencia");
                String country = sc.nextLine();
                System.out.println("Ingrese su email: ");
                String email = sc.nextLine();
                Profile newUser = new User(firstName, lastName, universityDegree, cellphoneNumber, country, email);
                selectOperationUser((User) newUser);
                break;
            case 2:
                System.out.println("Ingrese el nombre de la empresa: ");
                String name = sc.nextLine();
                System.out.println("Ingrese el tipo de la empresa: ");
                String industryType = sc.nextLine();
                System.out.println("Ingrese su pagina web: ");
                String website = sc.nextLine();
                System.out.println("Ingrese la ubicacion de su empresa: ");
                String ubication = sc.nextLine();
                System.out.println("Cual es la fecha de inaguracion de su empresa: ");
                String establishmentDate = sc.nextLine();
                System.out.println("Ingrese una descripcion breve de su empresa: ");
                String description = sc.nextLine();
                Profile newEnterprice = new Enterprise(name, industryType, website, ubication, establishmentDate, description);
                selectOperationEnterprise((Enterprise) newEnterprice);
                break;
            default:
                System.out.println("No ha ingresado una opcion correcta");
                break;
        }
    }

    private static void selectOperationEnterprise(Enterprise newEnterprice) {
        String enterpriseSubMenu = "Que desea hacer:" +
                "\n 1. Buscar personal\n2. Enviar Mensaje\n3.Leer Mensaje\n 4. Abrir Buzon \n 5. Publicar vacante\n 6. Salir";
        Scanner sc1 = new Scanner(System.in);
        int enterpriseOptionSubMenu = 0;
        while (enterpriseOptionSubMenu != 6) {
            System.out.println(enterpriseSubMenu);
            enterpriseOptionSubMenu = Integer.parseInt(sc1.nextLine());
            switch (enterpriseOptionSubMenu) {
                case 1:
                    APPLICANTFILTER filtro = getFiltroOfPeople();
                    String keyword = getKeywordForSearch();
                    ArrayList<User> usersSearchResults = newEnterprice.searchPersonal(filtro, keyword);
                    System.out.println(usersSearchResults);
                    break;
                case 2:
                    sendMessage(newEnterprice);
                    System.out.println("*********************Mensaje enviado*************************");
                    break;
                case 3:
                    receiveMessage(newEnterprice);
                    break;
                case 4:
                    System.out.println(newEnterprice.showMailbox());
                    break;
                case 5:
                    Scanner sv = new Scanner(System.in);
                    System.out.println("Ingrese el cargo: \t");
                    String jobTitle = sv.nextLine();
                    System.out.println("Ingrese una descripcion: \n");
                    String description = sv.nextLine();
                    newEnterprice.publicateVacant(jobTitle, description);
                    break;
                case 6:
                    enterpriseOptionSubMenu = 6;
                    break;

                default:
                    System.out.println("No ha ingresado una opcion correcta");
                    break;
            }
        }
    }

    private static void selectOperationUser(User newUser) {
        String usersSubMenu = "Que desea hacer? \n1. Buscar una vacante\n2. Enviar Mensaje\n3. Recibir Mensaje\n4. Abrir Buzon\n5. Crear Publicacion\n6. Interactuar con publicacion\n7. Crear un red de trabajo \n8. Ver redes de trabajo creadas \n 9. Ver Feed \n 10. Salir";
        Scanner sc2 = new Scanner(System.in);
        int userSubMenuOptions = 0;
        while (userSubMenuOptions != 9) {
            System.out.println(usersSubMenu);
            userSubMenuOptions = Integer.parseInt(sc2.nextLine());
            switch (userSubMenuOptions) {
                case 1:
                    VACANCYFITLER filter = getVacantsFilter();
                    String keyword = getKeywordForSearch();
                    ArrayList<Vacant> vacantsSearchResults = newUser.searchVacant(filter, keyword);
                    System.out.println(vacantsSearchResults);
                    break;
                case 2:
                    sendMessage(newUser);
                    System.out.println("*********************Mensaje enviado*************************");
                    break;
                case 3:
                    receiveMessage(newUser);
                    break;
                case 4:
                    System.out.println(newUser.showMailbox());
                    break;
                case 5:
                    System.out.println("Escriba un texto: \n");
                    String content = sc2.nextLine();
                    newUser.createPublication(content);
                    System.out.println("**********Publicacion creada***********");
                    break;
                case 6:
                    System.out.println("Escoja la publicacion con la cual desea interactuar: ");
                    System.out.println(newUser.showFeed());
                    String chosenID = sc2.nextLine();
                    String interectToPublicationMenu = "Menu de interaccion \n" + "1. Comentar publicacion \n 2. Reaccionar a publicacion \n 3. Salir";
                    System.out.println(interectToPublicationMenu);
                    int interectOption = Integer.parseInt(sc2.nextLine());
                    switch (interectOption) {
                        case 1:
                            System.out.println("Escriba un comentario para la publicacion");
                            String coment = sc2.nextLine();
                            newUser.comentToPublication(chosenID, coment);
                            System.out.println("Comentario enviado");
                            break;
                        case 2:
                            Reactions reaction = getReaction();
                            newUser.reactToPublication(reaction, chosenID);
                            System.out.println("Publicacion reaccionada");
                            break;
                    }
                    break;
                case 7:
                    System.out.println("Ingrese el nombre de la Networking \n");
                    String nameOfNetworking = sc2.nextLine();
                    System.out.println("Ingrese una descripcion de la Networking \n");
                    String description = sc2.nextLine();
                    System.out.println("Ingrese la razon de la Networking \n");
                    String subject = sc2.nextLine();
                    newUser.createNetworking(nameOfNetworking, description, subject);
                    String addUserMenu = "Networking\n1. Desea ingresar usuarios a tu networking?\n2. Salir \n";
                    System.out.println(addUserMenu);
                    int optionAddUser = Integer.parseInt(sc2.nextLine());
                    switch (optionAddUser) {
                        case 1:
                            System.out.println("Ingrese la id de su networking");
                            String idNw = sc2.nextLine();
                            System.out.println("Ingrese la id del usuario a ingresar");
                            String idUser = sc2.nextLine();
                            newUser.addUserToMyNetworking(idNw, idUser);
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("No ha ingresado una opcion correcta");
                            break;
                    }
                    break;
                case 8:
                    System.out.println(newUser.showNW());
                    break;
                case 9:
                    System.out.println(newUser.showFeed());
                    break;
                case 10:
                    userSubMenuOptions = 9;
                    break;
                default:
                    break;
            }
        }
    }

    private static void receiveMessage(Profile profile) {
        Scanner rm = new Scanner(System.in);
        System.out.println("Ingrese el ID del mensaje a leer: \t");
        String idUser = rm.nextLine();
        System.out.println(profile.readMessage(idUser));

    }

    private static String getKeywordForSearch() {
        Scanner sc3 = new Scanner(System.in);
        System.out.println("\tIngrese el termino a buscar: \t ");
        return sc3.nextLine();
    }

    private static APPLICANTFILTER getFiltroOfPeople() {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("\tFiltro: \n 1. Titulo universitario \n 2. Pais");
        int filterSubMenuOption = Integer.parseInt(sc2.nextLine());
        switch (filterSubMenuOption) {
            case 1:
                return APPLICANTFILTER.universityDegree;
            case 2:
                return APPLICANTFILTER.country;
            default:
                break;
        }
        return null;
    }

    private static Reactions getReaction() {
        Scanner r = new Scanner(System.in);
        System.out.println("\tFiltro: \n 1. Like \n 2. Me encanta \n 3. Estoy Interesado \n 4. Dislike");
        int opcionReaction = Integer.parseInt(r.nextLine());
        switch (opcionReaction) {
            case 1:
                return Reactions.LIKE;
            case 2:
                return Reactions.LOVE;
            case 3:
                return Reactions.INTERESTED;
            case 4:
                return Reactions.DISLIKE;
            default:
                break;
        }
        return null;
    }

    private static VACANCYFITLER getVacantsFilter() {
        Scanner sc3 = new Scanner(System.in);
        System.out.println("\tIngrese un Filtro: \n 1. Titulo del trabajo");
        int filterSubMenuOption = Integer.parseInt(sc3.nextLine());
        switch (filterSubMenuOption) {
            case 1:
                return VACANCYFITLER.jobTitle;
            default:
                break;
        }
        return null;
    }

    private static void sendMessage(Profile profile) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el mensaje que quiere enviar:");
        String content = s.nextLine();
        System.out.println("Ingrese el id del usuario a quien desee enviar:");
        String idUser = s.nextLine();
        profile.sendMessage(content, String.valueOf(idUser));
    }
    /*
        //SEARCH
        ((Enterprise) enterpriseUser).publicateVacant("Gerente Call", "Gerente Call Center de Sangolqui");

        ArrayList<Vacant> vacantsSearchResults = ((User) normalUserTest).searchVacant(VACANCYFITLER.jobTitle, "Gerente Call");
        System.out.println(vacantsSearchResults);
        ArrayList<User> usersSearchResults = ((Enterprise) enterpriseUser).searchPersonal(APPLICANTFILTER.universityDegree, "Ingeniero transporte");
        System.out.println(usersSearchResults);
        //Gestionar publicaciones
        normalUser.createPublication("No saben de una chamba por ay?1");
        normalUser.createPublication("No saben de una chamba por ay?2");
        normalUser.editPublication("2", "Este es el contenido editado2");
        normalUser.createPublication("No saben de una chamba por ay?3");
        normalUser.createPublication("No saben de una chamba por ay?4");
        normalUser.removePublication("2");

        //Interactuar con publicaciones
        normalUser.reactToPublication(Reactions.LIKE, "1");

        //--Coments
        normalUser.comentToPublication("1", "Yo si conozco un trabajo bro, inbox");
        System.out.println(normalUser.showFeed());

        //subsystemOfProfiles.Networking
        ((User) normalUser).createNetworking("Patos NW", "Este es un networking de patos", "Comercio");
        ((User) normalUser).addUserToMyNetworking("1", "1");
        System.out.println(((User) normalUser).showNW());
        System.out.println(((User) normalUserTest).showNW());
        */
}