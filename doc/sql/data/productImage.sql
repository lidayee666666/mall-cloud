alter table product modify image varchar(500)

-- 手机数码类商品图片
UPDATE `mall-product`.`product` SET `image` =
                                        CASE
                                            WHEN id = 3001 THEN 'http://img.alicdn.com/img/i4/1179720066/O1CN01LcQ7OY1CMH9kzK4h0_!!4611686018427386242-0-saturn_solar.jpg'
                                            WHEN id = 3002 THEN 'http://img.alicdn.com/img/i2/2208531962468/O1CN014Sfm1Z1U6ONTyrlJC_!!2208531962468-0-alimamacc.jpg_580x580q90.jpg_.webp'
                                            WHEN id = 3013 THEN 'http://img.alicdn.com/img/i3/5218037874/O1CN01l5gs5g282LfQ3Usip_!!4611686018427383922-0-saturn_solar.jpg'
                                            WHEN id = 3021 THEN 'http://img.alicdn.com/img/i1/15237275/O1CN01J2zIM723c0QDIPA5v_!!4611686018427379867-0-saturn_solar.jpg'
                                            WHEN id = 3030 THEN 'http://img.alicdn.com/img/i3/2464700053/O1CN01HImT1n1CGJlnF2OMf_!!0-saturn_solar.jpg'
                                            WHEN id = 3038 THEN 'http://img.alicdn.com/img/i1/1963410090/O1CN01RRUvYa1CXGeRYp7jK_!!4611686018427380394-0-saturn_solar.jpg'
                                            WHEN id = 3047 THEN 'http://img.alicdn.com/img/i4/2286400077/O1CN01uJRrRm1CRJXcKkNEC_!!4611686018427384397-0-saturn_solar.jpg'
                                            WHEN id = 3066 THEN 'https://img13.360buyimg.com/n1/s450x450_jfs/t1/174456/35/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg'
                                            WHEN id = 3083 THEN 'https://img12.360buyimg.com/n1/s450x450_jfs/t1/185456/35/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg'

                                            -- 家用电器类
                                            WHEN id = 3003 THEN 'http://img.alicdn.com/img/i1/19068296/O1CN01vHbr3b2B9cn5srTID_!!4611686018427385224-0-saturn_solar.jpg'
                                            WHEN id = 3004 THEN 'https://img.alicdn.com/imgextra/i3/2212424393116/O1CN01jRv0Pd1YtBBZvnsqs_!!2212424393116-0-alimamacc.jpg'
                                            WHEN id = 3007 THEN 'http://img.alicdn.com/img/i2/1643360180/O1CN01NglPlS1DCUILVzGrW_!!0-saturn_solar.jpg'
                                            WHEN id = 3022 THEN 'http://img.alicdn.com/img/i1/16639385/O1CN01wFY1402JCO7gzBWfH_!!4611686018427381145-0-saturn_solar.jpg'
                                            WHEN id = 3024 THEN 'http://img.alicdn.com/img/i2/6392002997/O1CN01cHNPoA1Y0g3OWFL92_!!4611686018427386293-0-saturn_solar.jpg'
                                            WHEN id = 3039 THEN 'https://img1.360buyimg.com/n6/jfs/t1/270355/26/9388/103445/67e0baf3F660eb8a9/1cd7b21baf4c8bf8.jpg'
                                            WHEN id = 3041 THEN 'http://img.alicdn.com/img/i2/110849235/O1CN01tSUlE42I5gN9SsesJ_!!0-saturn_solar.jpg'
                                            WHEN id = 3067 THEN 'https://img13.360buyimg.com/n1/s450x450_jfs/t1/174456/35/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg'
                                            WHEN id = 3069 THEN 'https://img12.360buyimg.com/n1/s450x450_jfs/t1/185456/35/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg'
                                            WHEN id = 3084 THEN 'https://img14.360buyimg.com/n1/s450x450_jfs/t1/125678/35/5947/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg'
                                            WHEN id = 3086 THEN 'https://img10.360buyimg.com/n1/s450x450_jfs/t1/129215/21/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg'

                                            -- 服装鞋帽类
                                            WHEN id = 3005 THEN 'http://img.alicdn.com/img/i4/2084640046/O1CN01gEz6de1CD7DGDYeju_!!0-saturn_solar.jpg'
                                            WHEN id = 3006 THEN 'http://img.alicdn.com/img/i3/111299660/O1CN01blUJxk2LEKzeBN9Wx_!!0-saturn_solar.jpg'
                                            WHEN id = 3023 THEN 'https://ilce.alicdn.com/minolta/483209/3/e18f3b6d49a977c392902657d059c207.jpg_800x800.jpg?channel=4&content=%7B%2211%22%3A%7B%22url%22%3A%22https%3A%2F%2Fimg.alicdn.com%2Fbao%2Fuploaded%2Fi3%2F664644235%2FO1CN013yTnbJ1h9gJxwfcQ6_%21%21664644235.jpg%22%2C%22filters%22%3A%5B%7B%22type%22%3A%22copy%22%2C%22attrs%22%3A%7B%22src_rect%22%3A%5B54%2C227%2C634%2C634%5D%2C%22dst_rect%22%3A%5B0%2C0%2C513%2C513%5D%7D%7D%5D%7D%7D&getAvatar=avatar_580x580q90.jpg_.webp'
                                            WHEN id = 3040 THEN 'http://img.alicdn.com/img/i1/1347990131/O1CN01ff8qUh1Cq2vjJkDjg_!!4611686018427384435-0-saturn_solar.jpg'
                                            WHEN id = 3068 THEN 'https://img14.360buyimg.com/n1/s450x450_jfs/t1/163456/35/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg'
                                            WHEN id = 3085 THEN 'https://img13.360buyimg.com/n1/s450x450_jfs/t1/174456/35/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg'

                                            -- 美妆个护类
                                            WHEN id = 3008 THEN 'http://img.alicdn.com/img/i3/688060003/O1CN01yfxe1q1BtQEU4QVGS_!!4611686018427385443-0-saturn_solar.jpg'
                                            WHEN id = 3025 THEN 'http://img.alicdn.com/img/i2/129059638/O1CN01aRi9fR2L4GKIiOqVK_!!4611686018427382582-0-saturn_solar.jpg'
                                            WHEN id = 3042 THEN 'http://img.alicdn.com/img/i2/117845398/O1CN01MJrdPD1pkL0YjfQzn_!!4611686018427383190-0-saturn_solar.jpg'
                                            WHEN id = 3054 THEN 'https://g-search3.alicdn.com/img/bao/uploaded/i4/i4/917264765/O1CN01FSUz3e1l4QIVM0Gkm_!!4611686018427386237-0-item_pic.jpg'
                                            WHEN id = 3070 THEN 'https://img12.360buyimg.com/n1/s450x450_jfs/t1/135456/12/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg'
                                            WHEN id = 3087 THEN 'https://img11.360buyimg.com/n1/s450x450_jfs/t1/142536/35/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg'

                                            -- 其他商品...
                                            WHEN id = 3009 THEN 'http://img.alicdn.com/img/i1/1884000171/O1CN01rVrB2R1D8MhofsVAF_!!0-saturn_solar.jpg'
                                            WHEN id = 3010 THEN 'http://img.alicdn.com/img/i3/58641111/O1CN01tIclZL1K4t3pvaXoL_!!4611686018427382487-0-saturn_solar.jpg'
                                            WHEN id = 3011 THEN 'http://img.alicdn.com/img/i4/34486274/O1CN014owLkF1wDXxSmdY6n_!!4611686018427385858-2-saturn_solar.png'
                                            WHEN id = 3012 THEN 'http://img.alicdn.com/img/i4/1240230048/O1CN01ziWPDz1CE20fPY7ca_!!0-saturn_solar.jpg'
                                            WHEN id = 3014 THEN 'http://img.alicdn.com/img/i3/55899220/O1CN01XB1BjH2HyolbejaqS_!!4611686018427384916-0-saturn_solar.jpg'
                                            WHEN id = 3015 THEN 'http://img.alicdn.com/img/i2/109253693/O1CN01couHnu1d9RXkXwpIT_!!0-saturn_solar.jpg_580x580q90.jpg_.webp'
                                            WHEN id = 3016 THEN 'http://img.alicdn.com/img/i4/2940140181/O1CN01CfBUS11DCwhdgqBCn_!!4611686018427386517-0-saturn_solar.jpg'
                                            WHEN id = 3017 THEN 'http://img.alicdn.com/img/i3/6604167987/O1CN01Z6shEI28s6PgSpzIJ_!!4611686018427386675-0-saturn_solar.jpg'
                                            WHEN id = 3018 THEN 'http://img.alicdn.com/img/i3/1496810002/O1CN01w0xAA91BsxobsJk6F_!!4611686018427380242-2-saturn_solar.png'
                                            WHEN id = 3019 THEN 'http://img.alicdn.com/img/i3/5218037874/O1CN01l5gs5g282LfQ3Usip_!!4611686018427383922-0-saturn_solar.jpg'
                                            WHEN id = 3020 THEN 'http://img.alicdn.com/img/i1/119533050/O1CN01uAPXkE1YOx1wLsOJG_!!4611686018427383290-0-saturn_solar.jpg'
                                            WHEN id = 3026 THEN 'http://img.alicdn.com/img/i3/7413206091/O1CN01St69Ix1urjTx22hil_!!4611686018427382859-0-saturn_solar.jpg'
                                            WHEN id = 3027 THEN 'http://img.alicdn.com/img/i4/271390167/O1CN012Ly9i21D6X72nAiJQ_!!0-saturn_solar.jpg'
                                            WHEN id = 3028 THEN 'https://g-search3.alicdn.com/img/bao/uploaded/i4/i2/6000000003611/O1CN01wQF9tU1cXtEvALiWW_!!6000000003611-2-mia.png'
                                            WHEN id = 3029 THEN 'http://img.alicdn.com/img/i3/54709221/O1CN01hOE3jV2HzH9gBoikz_!!4611686018427382757-0-saturn_solar.jpg'
                                            WHEN id = 3031 THEN	'http://img.alicdn.com/img/i2/2201503044793/O1CN011N8HBx1lHFI8xvmQC_!!2201503044793-0-alimamacc.jpg'
                                            WHEN id = 3032 THEN	'http://img.alicdn.com/img/i3/328340019/O1CN01d3ttV81C0kZOhPWJy_!!4611686018427384371-0-saturn_solar.jpg'
                                            WHEN id = 3033 THEN	'http://img.alicdn.com/img/i2/1280570023/O1CN01X8j9Ga1C2a8oCbWp3_!!4611686018427384487-0-saturn_solar.jpg'
                                            WHEN id = 3034 THEN 'https://img.alicdn.com/imgextra/i4/2937783914/O1CN01DZNVuf1emfFJborNA_!!2937783914-0-alimamacc.jpg'
                                            WHEN id = 3035 THEN 'http://img.alicdn.com/img/i4/2475900067/O1CN01hzy1mM1CMjZyEtzF3_!!4611686018427387043-0-saturn_solar.jpg'
                                            WHEN id = 3036 THEN 'http://img.alicdn.com/img/i2/108572212/O1CN01Yvms4Y1SD98uwj5ah_!!4611686018427383348-0-saturn_solar.jpg'
                                            WHEN id = 3037 THEN 'http://img.alicdn.com/img/i3/583370131/O1CN01QQkaSr1Cq2oEGf0fi_!!0-saturn_solar.jpg'
                                            WHEN id = 3043 THEN 'http://img.alicdn.com/img/i2/55796337/O1CN01gnc9u61wgOesEA5Ru_!!0-saturn_solar.jpg'
                                            WHEN id = 3044 THEN 'https://img.alicdn.com/imgextra/i1/1808944664/O1CN01CRZry51kKAHjDMWNv_!!1808944664-0-alimamacc.jpg'
                                            WHEN id = 3045 THEN 'http://img.alicdn.com/img/i2/1400450138/O1CN01tVALrF1CtFhMljBLV_!!4611686018427382874-0-saturn_solar.jpg'
                                            WHEN id = 3046 THEN 'http://img.alicdn.com/img/i1/7518902247/O1CN01qzFB5Q1STB0Lz3dWK_!!4611686018427385831-0-saturn_solar.jpg_580x580q90.jpg_.webp'
                                            WHEN id = 3048 THEN 'http://img.alicdn.com/img/i4/107453279/O1CN01S6J1YW1a5pjpqFACN_!!4611686018427386719-0-saturn_solar.jpg'
                                            WHEN id = 3049 THEN 'http://img.alicdn.com/img/i2/5263328257/O1CN01ePwPy52ArlKsycrfS_!!4611686018427380737-0-saturn_solar.jpg'
                                            WHEN id = 3050 THEN 'http://img.alicdn.com/img/i4/3130538718/O1CN01P1lEeD2EGtwaqRCcZ_!!4611686018427386590-0-saturn_solar.jpg'
                                            WHEN id = 3051 THEN 'http://img.alicdn.com/img/i4/1665580011/O1CN01ilh3zG1Bx5OPTD7TQ_!!4611686018427386859-2-saturn_solar.png'
                                            WHEN id = 3052 THEN 'http://img.alicdn.com/img/i4/25577833/O1CN01Jpb3Ac27jZPbmJSCE_!!4611686018427382121-0-saturn_solar.jpg'
                                            WHEN id = 3053 THEN 'http://img.alicdn.com/img/i1/3526856527/O1CN01Pix6NN1y5QA5Q5fnG_!!4611686018427383631-0-saturn_solar.jpg_580x580q90.jpg_.webp'
                                            WHEN id = 3100 THEN 'https://g-search3.alicdn.com/img/bao/uploaded/i4/i2/6000000003611/O1CN01wQF9tU1cXtEvALiWW_!!6000000003611-2-mia.png'
                                            -- 默认图片
                                            ELSE 'https://img13.360buyimg.com/n1/s450x450_jfs/t1/174456/35/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg'
                                            END;









update product set image='https://img.alicdn.com/bao/uploaded/i2/2213190082472/O1CN01U8H5AD1U8DsFGPfx2_!!2213190082472-0-tblite.jpg_460x460q90.jpg_.webp'
where image='https://img.alicdn.com/bao/uploaded/i1/2217844048986/O1CN01Eqg58q2GFe0JWXDMY_!!0-item_pic.jpg_460x460q90.jpg_.webp'
